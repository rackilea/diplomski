if test "x$LD_LIBRARY_PATH" != "x" ; then
  LD_LIBRARY_PATH="/path/to/httpd/lib:/path/to/httpd/weblogic-module/lib:$LD_LIBRARY_PATH"
else
  LD_LIBRARY_PATH="/path/to/httpd/lib:/path/to/httpd/weblogic-module/lib"
fi
export LD_LIBRARY_PATH