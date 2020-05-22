@if(form.hasErrors) {
  <div class="form-group">
    <div class="alert alert-danger col-lg-6 text-center">
      @for(entry <- form.errors.entrySet){
        @for(error <- entry.getValue){
          @error.message <br/>
        }
      }
    </div>
  </div>
}