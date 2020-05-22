dataPointsService.getDataPoints(AsyncCallback<Number[]>(){

          @Override
          public void onSuccess(Number[] result) {
            // result contains the returning values
          }

          @Override
          public void onFailure(Throwable caught) {
            Window.alert("panic");
          }
});