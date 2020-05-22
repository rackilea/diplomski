// boolean promote, promotes a level up
    public boolean promote()
    {
        if (level.equals("apprentice"))
        {
            level = "wizard";
            galleons +=100;
            return true;
        }
        else if (level.equals("wizard"))
        {
            level = "mage";
            galleons +=100;
            return true;
        }
        else if (level.equals("mage"))
        {
            level = "sorcerer";
            galleons +=100;
            return true;
        }
        else if (level.equals("sorcerer"))
        {
            level = "shaman";
            galleons +=100;
            return true;
        }
        else if (level.equals("shaman"))
        {
            return false;
        }
        return true;
    }