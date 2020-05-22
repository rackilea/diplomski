@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getRequest().getId() == null) ? 0 : getRequest().getId().hashCode());
    result = prime * result + ((getRequest().getName() == null) ? 0 : getRequest().getName().hashCode());
    result = prime * result + ((getRequest().getHid() == null) ? 0 : getRequest().getHid().hashCode());
    return result;
}