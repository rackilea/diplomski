package org.aap.checks;

import com.google.common.collect.Lists;
import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import com.puppycrawl.tools.checkstyle.api.AutomaticBean;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.Filter;
import com.puppycrawl.tools.checkstyle.checks.FileContentsHolder;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SuppressWithAnnotationFilter
        extends AutomaticBean
        implements Filter {

    public class Tag implements Comparable<Tag> {
        private final int firstLine;
        private final int lastLine;

        public Tag(int firstLine, int lastLine) {
            this.firstLine = firstLine;
            this.lastLine = lastLine;
        }

        @Override
        public int compareTo(Tag other) {
            if (firstLine == other.firstLine) {
                return lastLine - other.lastLine;
            }
            return (firstLine - other.firstLine);
        }

        public boolean isMatch(AuditEvent event) {
            final int line = event.getLine();
            return line >= firstLine && line <= lastLine;
        }

        @Override
        public final String toString() {
            return "Tag[lines=" + firstLine + " to " + lastLine + "]";
        }
    }

    private final List<Tag> tags = Lists.newArrayList();
    private WeakReference<FileContents> fileContentsReference =
            new WeakReference<FileContents>(null);

    public FileContents getFileContents() {
        return fileContentsReference.get();
    }

    public void setFileContents(FileContents fileContents) {
        fileContentsReference = new WeakReference<FileContents>(fileContents);
    }

    @Override
    public boolean accept(AuditEvent event) {
        if (event.getLocalizedMessage() == null) {
            return true;        // A special event.
        }

        final FileContents currentContents = FileContentsHolder.getContents();
        if (currentContents == null) {
            return true;
        }
        if (getFileContents() != currentContents) {
            setFileContents(currentContents);
            tagSuppressions();
        }
        for (final Iterator<Tag> iter = tags.iterator(); iter.hasNext(); ) {
            final Tag tag = iter.next();
            if (tag.isMatch(event)) {
                return false;
            }
        }
        return true;
    }

    private void tagSuppressions() {
        tags.clear();
        final FileContents contents = getFileContents();

        String[] contentsLines = contents.getLines();
        for (int i = 0; i < contentsLines.length; i++) {
            if (contentsLines[i].contains("@FindBy")) {
                tags.add(new Tag(i+1, i+2));
            }
        }

        Collections.sort(tags);
    }
}