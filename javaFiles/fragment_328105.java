for (Task tempTask : TasksListAppObj.getInstance().tasksRepository.getTasksRepository())
                {
                    LatLng latlng = new LatLng(tempTask.getLatitude(), tempTask.getLongtitude());
                    if (tempTask.getStatus().contentEquals(TasksListActivity.STATUS_WAITING))
                    {
                        newmarker = map.addMarker(new MarkerOptions().position(latlng).title(tempTask.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_for_map_blue)));
                    }
                    else if (tempTask.getStatus().contentEquals(TasksListActivity.STATUS_IN_PROGRESS))
                    {
                        newmarker = map.addMarker(new MarkerOptions().position(latlng).title(tempTask.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_for_map_bordo)));
                    }
                    else if (tempTask.getStatus().contentEquals(TasksListActivity.STATUS_ON_THE_WAY))
                    {
                        newmarker = map.addMarker(new MarkerOptions().position(latlng).title(tempTask.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_for_map_turkiz)));
                    }
                    else if (tempTask.getStatus().contentEquals(TasksListActivity.STATUS_COMPLETE))
                    {
                        newmarker = map.addMarker(new MarkerOptions().position(latlng).title(tempTask.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_for_map_orange)));
                    }
                    else if (tempTask.getStatus().contentEquals(TasksListActivity.STATUS_FAILED))
                    {
                        newmarker = map.addMarker(new MarkerOptions().position(latlng).title(tempTask.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_for_map_purpul)));
                    }
}