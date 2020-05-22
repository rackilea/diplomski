@XmlRootElement(name = "fileVersionListWrapper")
public class FileVersionListWrapper
{
  private ArrayList<VersionList> versionListArrayList = new ArrayList<VersionList>();

  public ArrayList<VersionList> getVersionListArrayList()
  {
    return versionListArrayList;
  }

  @XmlElement(name = "VersionList")
  public void setVersionListArrayList(ArrayList<VersionList> versionListArrayList)
  {
    this.versionListArrayList = versionListArrayList;
  }
}