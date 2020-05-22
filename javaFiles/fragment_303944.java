import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ParseTree {

    public PackageInfo getRoot(List<String> packages) throws JsonProcessingException {
        Map<String, PackageInfo> map = new HashMap<>();

        String root = null;
        for (String packageName : packages) {
            String[] split = packageName.split("\\.");
            for (int i = 0; i < split.length; i++) {
                String singlePackage = split[i];
                if (root == null) {
                    root = singlePackage;
                }
                map.computeIfAbsent(singlePackage, PackageInfo::new);
                if (i - 1 >= 0) {
                    PackageInfo currentPackage = map.get(singlePackage);
                    map.get(split[i - 1]).getChildren().add(currentPackage);
                }
            }
        }

        return map.get(root);
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<String> packages = Arrays.asList("com.project.server",
            "com.project.client",
            "com.project.client.util", "com.project.client.util.some");

        ParseTree parseTree = new ParseTree();
        PackageInfo root = parseTree.getRoot(packages);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(root));
    }
}

class PackageInfo {

    private String name;
    private Set<PackageInfo> children;

    public PackageInfo(String name) {
        this.name = name;
        children = new HashSet<>();
    }

    public Set<PackageInfo> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PackageInfo that = (PackageInfo) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PackageInfo{" +
            "name='" + name + '\'' +
            ", children=" + children +
            '}';
    }
}