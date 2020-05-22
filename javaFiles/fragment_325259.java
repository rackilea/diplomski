TextView tipView = (TextView) LayoutInflater.from(this).inflate(R.layout.item_tooltip, null, false).getRootView();
Tooltip tip = new Tooltip.Builder()
        .attachTooltipView(tipView)
        .withEnterAnimation(new AnimationComposer<BaseViewAnimator>(new FadeInAnimator()).duration(500))
        .withExitAnimation(new AnimationComposer<BaseViewAnimator>(new FadeOutAnimator()).duration(500))
        .withGravity(TipVerticalGravity.BOTTOM, TipHorizontalGravity.LEFT)
        .withAnchorView(loginButton)
        .build();

List<Tip> tips = new ArrayList<>();
tips.add(tip);
final LinkedBlockingQueue<Tip> tooltipsQueue = new LinkedBlockingQueue<>(tips);
TipsManager.showTips(rootView, R.color.colorAccent, new Function0<Queue<Tip>>() {
    @Override
    public Queue<Tip> invoke() {
        return tooltipsQueue;
    }
});