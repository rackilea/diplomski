// Only relevant lines are kept.
public class CustomEventAction implements EventActionHandler {
    // [...]
    public void onEvent(ObjectChangeEvent event, Id eventId) {
        if (event instanceof CreationEvent) {
            ObjectStore os = event.getObjectStore();
            Id id = event.get_SourceObjectId();
            FilterElement fe = 
                    new FilterElement(null, null, null, "permissions creator", null);
            PropertyFilter pf = new PropertyFilter();
            pf.addIncludeProperty(fe);
            Document doc = Factory.Document.fetchInstance(os, id, pf);

            AccessPermissionList permissions;

            String creatorGranteeName = getCreatorGranteeName(doc);
            permissions = doc.get_Permissions();
            Iterator<AccessPermission> iter = permissions.iterator();

            boolean found = false;
            while (iter.hasNext()) {
                AccessPermission ace = (AccessPermission) iter.next();
                if (ace.get_GranteeName().equals(creatorGranteeName)) {
                    permissions.remove(ace);
                    found = true;
                    break;
                }
            }

            if (!found) {
                return;
            }

            doc.save(RefreshMode.REFRESH);
        }
    }
}