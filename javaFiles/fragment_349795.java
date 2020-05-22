org.apache.hadoop.hbase.filter.SingleColumnValueFilter

/**
 * Set whether entire row should be filtered if column is not found.
 * 
 * If true, the entire row will be skipped if the column is not found.
 * 
 * If false, the row will pass if the column is not found.  This is default.
 * @param filterIfMissing flag
 */
public void setFilterIfMissing(boolean filterIfMissing) {
  this.filterIfMissing = filterIfMissing;
}