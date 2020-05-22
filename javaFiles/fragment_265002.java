So total elements = page 0(2) + (page 1(2) + 1) 
page 1(2) + 1 -- > 3 values 


/**
 * Constructor of {@code PageImpl}.
 * 
 * @param content the content of this page, must not be {@literal null}.
 * @param pageable the paging information, can be {@literal null}.
 * @param total the total amount of items available. The total might be adapted considering the length of the content
 *          given, if it is going to be the content of the last page. This is in place to mitigate inconsistencies
 */
public PageImpl(List<T> content, Pageable pageable, long total) {

    super(content, pageable);

    this.pageable = pageable;
    this.total = pageable.toOptional().filter(it -> !content.isEmpty())//
            .filter(it -> it.getOffset() + it.getPageSize() > total)//
            .map(it -> it.getOffset() + content.size())//
            .orElse(total);
}