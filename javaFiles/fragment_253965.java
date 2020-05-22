public class assignment... {
    private List<String> list = new ArrayList<>();
    ....
    public void actionPerfomed(ActionEvent e) {
        ....
        // instead of this
        //for (b = 0; b < pr_count.length; b++){
            //if (pr_count[b] > 0) {
            //pr_name = ("There are " + pr_count[b] + " words of length " + b); 
            //repaint();
        //}

        // do this
        for (b = 0; b < pr_count.length; b++){
            if (pr_count[b] > 0) {
                list.add("There are " + pr_count[b] + " words of length " + b);
            }
        }
        repaint();  // repaint after all is added to the list.
    }
}