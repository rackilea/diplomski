import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ScoreStorage {
    private static final int MAX_NUM_SCORES = 3;

    private static final String SCORE_PREFERENCE_KEY_PREFIX = "score-";

    private ObservableList<Integer> scores = FXCollections.observableArrayList();
    private Preferences scorePreferences = Preferences.userNodeForPackage(
        ScoreStorage.class
    );

    public ScoreStorage() throws BackingStoreException {
        for (String key: scorePreferences.keys()) {
            scores.add(scorePreferences.getInt(key, 0));
        }
    }

    public ObservableList<Integer> getUnmodifiableScores() {
        return FXCollections.unmodifiableObservableList(scores);
    }

    public void clearScores() {
        scores.clear();
        storeScores();
    }

    public void recordScore(int score) {
        int i = 0;
        while (i < MAX_NUM_SCORES && i < scores.size() && scores.get(i) >= score) {
            i++;
        }

        if (i < MAX_NUM_SCORES) {
            if (scores.size() == MAX_NUM_SCORES) {
                scores.remove(scores.size() - 1);
            }
            scores.add(i, score);
            storeScores();
        }
    }

    private void storeScores() {
        int i = 0;
        for (int score: scores) {
            scorePreferences.putInt(SCORE_PREFERENCE_KEY_PREFIX + i, score);
            i++;
        }
        while (i < MAX_NUM_SCORES) {
            scorePreferences.remove(SCORE_PREFERENCE_KEY_PREFIX + i);
            i++;
        }
    }
}