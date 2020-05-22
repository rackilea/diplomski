//Warning on "baz"
foo("bar","baz"); //$NON-NLS-1$

//Warning on "bar"
foo("bar","baz"); //$NON-NLS-2$

//No warnings
foo("bar","baz"); //$NON-NLS-1$  //$NON-NLS-2$

//Warning on "baz" (apparently the slashes are required even with multiple tags)
foo("bar","baz"); //$NON-NLS-1$  $NON-NLS-2$