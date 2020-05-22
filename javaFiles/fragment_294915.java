package com.test;

public class ClassToCopy implements Cloneable {

    private int varA;

    /**
     * Constructor for ClassToCopy.
     * @param varA <tt></tt>
     */
    public ClassToCopy() {
        this(-1);
    }

    /**
     * Constructor for ClassToCopy.
     * @param varA <tt></tt>
     */
    public ClassToCopy(int varA) {
        super();
        this.varA = varA;
    }

    /**
     * Gets the varA.
     * 
     * @return <tt> the varA.</tt>
     */
    public int getVarA() {
        return varA;
    }

    /**
     * Sets the varA.
     *
     * @param varA <tt> the varA to set.</tt>
     */
    public void setVarA(int varA) {
        this.varA = varA;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassToCopy : "+super.toString()+" [varA=" + varA + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

}