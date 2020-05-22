import org.tigris.subversion.javahl.*;
[...]

SVNClient svnClient = new SVNClient();
@SuppressWarnings("deprecation")
Status [] status = svnClient.status("absolutepathOfTheProject", true, false, true);

for(Status stat : status)
revNumber = (revNumber < stat.getRevisionNumber()) ? stat.getRevisionNumber() : revNumber;