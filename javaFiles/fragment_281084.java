public class MainClass {
  private final RewardValue rewardValue = new RewardValue(0);

  public MainClass() {
    //initiate update 
    //...

    update.addActionListener(new RewardUpdater(rewardValue));

    //of cause the next lines don't need to be in the constructor
    if (argument) {
      rewardUpdater.increment();
    }
  }
}

public class RewardUpdater implements ActionListener {
  private final RewardValue rewardValue;

  public RewardUpdater(RewardValue rewardValue) {
    this.rewardValue = rewardValue;
  }

  public void actionPerformed(AcionEvent e) {
    //... the other lines
    text.setText("Test: "+rewardValue.get());
    // ... the other lines
  }
}