public class TimerFragment extends Fragment {

    public TimerFragment() { }

    private static int ONE_MINUTE_MILLIS = (int) TimeUnit.MINUTES.toMillis(1);

    private ProgressBar progressBar;
    private ObjectAnimator animator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax(ONE_MINUTE_MILLIS);
        progressBar.setProgress(ONE_MINUTE_MILLIS);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStopTimer();
            }
        });
    }

    private void startStopTimer() {
        if(animator == null) {
            animator = ObjectAnimator.ofInt(progressBar, "progress", ONE_MINUTE_MILLIS, 0);
            animator.setDuration(ONE_MINUTE_MILLIS);
            animator.setInterpolator(new LinearInterpolator());
            animator.start();
        } else {
            animator.cancel();
            animator = null;
            progressBar.setProgress(ONE_MINUTE_MILLIS);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(animator != null) {
            animator.cancel();
            animator = null;
        }
    }
}