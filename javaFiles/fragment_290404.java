import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.action.admin.cluster.node.info.PluginInfo;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

...

        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "es160").build();
        final Client client = new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));

        NodesInfoResponse nodesInfoResponse = client.admin().cluster().prepareNodesInfo().clear().setPlugins(true).get();
        for (PluginInfo pluginInfo : nodesInfoResponse.getNodes()[0].getPlugins().getInfos()) {
            System.out.println(pluginInfo.getName());            
        }
...