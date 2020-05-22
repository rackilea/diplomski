public void setCPUTemperature(String CPUTemp){
    this.mCPUTemp = Double.parseDouble((String)CPUTemp);
    notifyPropertyChanged(BR.cPUTemperature);
}

public void setCPUTemperature(double CPUTemp){
    this.mCPUTemp = CPUTemp;
    notifyPropertyChanged(BR.cPUTemperature);
}