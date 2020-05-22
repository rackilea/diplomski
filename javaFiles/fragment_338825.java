public void setupComponent(ApplicationComponent appComponent){
appComponent.plus(new MainModule(this)).inject(this)
}

public void setupComponent(ApplicationComponent appComponent){
appComponent.plus(new LoginModule(this)).inject(this)
}