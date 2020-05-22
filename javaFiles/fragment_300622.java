# backup the log files before starting
if [ -f "$SOLR_LOGS_DIR/solr.log" ]; then
  if $verbose ; then
    echo "Backing up $SOLR_LOGS_DIR/solr.log"
  fi
  mv "$SOLR_LOGS_DIR/solr.log" "$SOLR_LOGS_DIR/solr_log_$(date +"%Y%m%d_%H%M")"
fi