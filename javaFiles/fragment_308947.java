import org.glassfish.flashlight.MonitoringRuntimeDataRegistry;
import org.glassfish.flashlight.datatree.TreeNode;
import javax.annotation.Resource;

@Resource
private MonitoringRuntimeDataRegistry datareg;

private String showOneNode() {
    StringBuilder sb = new StringBuilder("<ul>\n");
    TreeNode mainNode = datareg.get("server");
    List<TreeNode> ltn = mainNode.getNodes("server.web.request.*");

    for(TreeNode tn : ltn) {
        String val = tn.getValue().toString();
        sb.append("<li>").append(tn.getCompletePathName() + val);
    }

    sb.append("</ul>");
    return sb.toString();
}