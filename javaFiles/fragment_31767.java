bnd.bnd:
 # standard set that uses macros for the places where specials need to be insered
 -runbundles: \
        ....
        ${platformdeps}

 windows.bndrun:
 -include bnd.bnd
 platformdeps = org.eclipse.swt.win.x86.jar