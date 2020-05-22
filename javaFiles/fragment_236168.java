setOnKeyPressed((event) -> {
     if (event.getCode() == KeyCode.DOWN && getCenterY() < getScene().getHeight()){
         setCenterY(getCenterY() + 5);
     } else if (event.getCode() == KeyCode.UP && getCenterY() > 0) {
         setCenterY(getCenterY() - 5);
     }
});