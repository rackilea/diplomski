package app;

import org.apache.commons.lang.StringUtils;
import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Set;
import static app.Language.*;
import static com.google.common.base.Preconditions.*;

enum Language {
    ITALIAN,
    ENGLISH,
    MALTESE
}

public enum Country {

    ITALY(new Builder(1, "Italy").addLanguage(ITALIAN)),
    MALTA(new Builder(2, "Malta").addLanguages(MALTESE, ENGLISH, ITALIAN).setPopulation(450_000));

    final private int id;
    final private String name;
    final private Integer population;
    final private Set<Language> languages;

    private static class Builder {

        private int id;
        private String name;
        private Integer population;
        private Set<Language> languages = EnumSet.noneOf(Language.class);

        public Builder(int id, String name) {
            checkArgument(!StringUtils.isBlank(name));

            this.id = id;
            this.name = name;
        }

        public Builder setPopulation(int population) {
            checkArgument(population > 0);

            this.population = population;
            return this;
        }

        public Builder addLanguage(Language language) {
            checkNotNull(language);

            this.languages.add(language);
            return this;
        }

        public Builder addLanguages(Language... language) {
            checkNotNull(language);

            this.languages.addAll(languages);
            return this;
        }
    }

    private Country(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.population = builder.population;
        this.languages = builder.languages;

        checkState(!this.languages.isEmpty());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public Integer getPopulation() {
        return population;
    }

    public Set<Language> getLanguages() {
        return languages;
    }
}