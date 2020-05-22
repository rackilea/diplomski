@Override
public void actionPerformed(ActionEvent e)
{
  new Thread(new Runnable() {
    @Override
    public void run() {
      for (int i = 0; i < iter; i++)
      {
        final String display = String.format("%10d\n", i);
        try {
          EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
              append(display);
            }
          });
        } catch (Exception e) {
          e.printStackTrace();
        }
      } // end for i
    }
  }).start();
}