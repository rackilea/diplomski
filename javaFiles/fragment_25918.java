private class SortButtonListener implements ActionListener
{
    private int[] arr;
    private SortRunnable sr;

    public void actionPerformed(ActionEvent e)
    {
        ExecutorService es = Executors.newSingleThreadExecutor();
        //TODO: Finish Implementation
        if(e.getSource() == sortButton)
        {
            sortingAlgorithms.setEnabled(false);
            sortButton.setEnabled(false);
            loadingIcon.setVisible(true);
            display.setText("N\t\tRuntime (ms)");
        }
        arr = new int [2000];
        for(int i = 0; i <= 8; i++)
        {
            arr = new int [(int) Math.pow(2, i) * 1000];
            fillArr();
            sr = new SortRunnable((String) sortingAlgorithms.getSelectedItem(), arr, Sorter.this);
            es.execute(sr);
        }
        es.shutdown();
    }
    private void fillArr()
    {
        Random r = new Random();
        for(int i=0; i<arr.length; ++i)
        {
            arr[i] = r.nextInt();
        }
    }
}