search.setFields("items(kind,id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url),nextPageToken,pageInfo,prevPageToken");

System.out.println("PAGE INFO: " +response.getPageInfo());

System.out.println("next page token :" +response.getNextPageToken());

System.out.println("prev page token:"+ response.getPrevPageToken());