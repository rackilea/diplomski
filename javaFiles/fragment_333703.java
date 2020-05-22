Button increase = .......
Button decrease = .......

SeekBar seek = .......

increase.setOnClickListener(new OnClickListener() {           

  @Override
  public void onClick(View v) 
  {
      seek.setProgress(seek.getProgress() + toBeIncreasedBy);
  }    
});

decrease.setOnClickListener(new OnClickListener() {           

  @Override
  public void onClick(View v) 
  {
      seek.setProgress(seek.getProgress() - toBeDecreasedBy);
  }    
});