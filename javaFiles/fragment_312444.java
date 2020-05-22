public class MapIconRender extends DefaultClusterRenderer<ClusterRequest> {

        public MapIconRender(Context context, GoogleMap map,
                             ClusterManager<ClusterRequest> clusterManager) {
            super(context, map, clusterManager);
        }

            @Override
            protected void onBeforeClusterItemRendered (ClusterRequest item, MarkerOptions
            markerOptions){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_outside_azure));
                markerOptions.snippet("Status: ");
                markerOptions.title("Title: " + item.stopName); //Now we can access the title of the marker by calling item.variableName
                super.onBeforeClusterItemRendered(item, markerOptions);
            }
}