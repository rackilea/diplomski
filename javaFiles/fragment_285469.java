package packageNameHere;


import org.springframework.data.domain.Page;

/**
 * @author Inzimam Tariq
 */
public class Pager {

    private final Page<SlUrl> urls;

    public Pager(Page<SlUrl> urls) {
        this.urls = urls;
    }

    public int getPageIndex() {
        return urls.getNumber() + 1;
    }

    public int getPageSize() {
        return urls.getSize();
    }

    public boolean hasNext() {
        return urls.hasNext();
    }

    public boolean hasPrevious() {
        return urls.hasPrevious();
    }

    public int getTotalPages() {
        return urls.getTotalPages();
    }

    public long getTotalElements() {
        return urls.getTotalElements();
    }

    public Page<SlUrl> getSlUrls() {
        return urls;
    }

    public boolean indexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalElements();
    }

}