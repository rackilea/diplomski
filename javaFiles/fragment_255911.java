<form action="{{route('products.store')}}" method="POST" enctype="multipart-data">
        {{csrf_field()}}
       <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" name="title" class="form-control" placeholder="Title...">
        </div>
     </form>