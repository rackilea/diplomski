for (String string : classNameList) {
    Class actualClass = Class.forName(className);
    Object classObj = actualClass.newInstance();
    Method doOp = this.getClass().getDeclaredMethod("doOperation", actualClass);
    doOp.setAccessible(true);
    doOp.invoke(this, classObj);                            
}