import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.jdt.core.ICompilationUnit;

...

ICompilationUnit cu = ...

...

CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
ISourceRange range = cu.getSourceRange();
TextEdit indent_edit =
  formatter.format(CodeFormatter.K_COMPILATION_UNIT, 
    cu.getSource(), range.getOffset(), range.getLength(), 0, null);
cu.applyTextEdit(indent_edit, null);

cu.reconcile();