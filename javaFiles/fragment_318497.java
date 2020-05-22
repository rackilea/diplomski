public class Diamond {
    private List<String> shape = null;

    public void createShape(int num) {
        shape = new ArrayList<String>();
        String shapeLine = "";
        for(int ucount=num;ucount>0;ucount--) {
            for(int count_sp=1;count_sp<ucount;count_sp++) {
                shapeLine += " ";
            }
            for(int count_ast=num;count_ast>=ucount;count_ast--) {
                shapeLine += "* ";
            }
            shape.add(shapeLine);
        }

        shapeLine = "";
        for(int lcount=1;lcount<num;lcount++) {
           for(int count_sp=0;count_sp<lcount;count_sp++) {
                shapeLine += " ";
           }
           for(int count_ast=num-1;count_ast>=lcount;count_ast--) {
               shapeLine += "* ";
           }
           shape.Add(shapeLine);
        }
    } 

    public void printShape(OutStream out) {
        if(shape != null) {
            for(String shapeLine : shape) {
                out.println(shapeLine);
            }
        }
    }

    public List<String> getShape() {
        return shape;
    } 
}