public static final int PROJECT_REQUEST_CODE = 1;
public static final int CAMERA_REQUEST_CODE = 2;
public static .....
if (item == 0) {
     Intent intent = new Intent(getActivity().getApplicationContext(), Project1.class);
     startActivityForResult(intent, PROJECT_REQUEST_CODE);
}
else if .....