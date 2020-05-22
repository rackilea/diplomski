public double getCPUTemperature(){
    return this.mCPUTemp;
}

public void setCPUTemperature(double CPUTemp){
    this.mCPUTemp = CPUTemp;
    notifyPropertyChanged(BR.cPUTemperature);
}