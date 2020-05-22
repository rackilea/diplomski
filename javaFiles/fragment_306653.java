public interface ApiInterface {
@Headers({
        "Content-Type:application/x-www-form-urlencoded"
})

@POST("v1/users/check_status")
Call<CheckEmail> getEmailStatus(@Body String email);
}