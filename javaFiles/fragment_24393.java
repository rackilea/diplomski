@Override
public void onEnable(){
  this.getServer().getPluginManager().registerEvents(new SignBuyEvent(), this);

  //other things that you have in your onEnable here
}