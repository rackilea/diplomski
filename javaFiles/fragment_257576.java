interface View{
void displayExitMessage()
}

class CommandLineView implements View{

void displayExitMessage(){
    this.commandLine.append("Are you sure you want to exit(Y/N)?");
}
}

class CommandLineView implements View{

void displayExitMessage(){
    this.window.showDialog("Are you sure you want to exit?", Button.YES, Button.NO);
}
}