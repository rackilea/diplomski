@Controller
public SseController {
    private final List<SseEmitter> emitters = new ArrayList<>();

    @GetMapping("/listen")
    public SseEmitter getEvents() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        return emitter;
    }

    @PostMapping("/notify")
    public void postMessage(String message) {
        for (SseEmitter emitter : emitters) {
            emitter.send(message);
        }
    }
}