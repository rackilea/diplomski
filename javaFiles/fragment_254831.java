Player comp = (Player) o;
if (!comp.team.equals(this.team))
    return false;
if (comp.jerseyNumber != this.jerseyNumber)
    return false;
return true;