import retrofit2.Call;
import retrofit2.http.GET;
...

@GET("institute/students")
Call<ArrayList<Student>> getStudents();