appName_ = " ";
    for (int i = 0; i < systemButton_.length; i++)
    {   
        if (systemButton_[i].getButtonDimesion().contains(mousePosition))
        {
            appName_ = systemButton_[i];  
        }
    }
    repaint();