public void findSpringfield(PrintStream out)
{
    out.println("------------------------------------------------------------------------");
    out.println("SPRINGFIELD ZIP CODES");

    for(int i=0; i < data2.length ; i++) {
        if(data2[i].getpostalCity().contains("SPRINGFIELD")) {
            out.println(data2[i].getzipCode().replaceAll("\"",""));  //Prints out zipCodes that have Springfield in them
        }
    }
}