private class Something {
    public void yeah() {
        System.out.println("");            
    }
}

private class Something2 extends Something{        
    @Override
    public void yeah(){
        super.yeah();
    }
}