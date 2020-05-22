public void addToList(String output)
    {
        if (validateInput(output) == true)
        {
            this.selected_modules.addElement("   " + output);
            this.module_counter += 1;
            setChanged();
            notifyObservers();
        }
    }