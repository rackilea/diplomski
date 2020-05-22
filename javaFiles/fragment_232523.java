ParameterizedType genericHttpEntity = (ParameterizedType) t;

Class<?> httpEntity = (Class<?>) genericHttpEntity.getRawType();

ParameterizedType genericDendriteEnvelope =
    (ParameterizedType) genericHttpEntity.getActualTypeArguments()[0];

Class<?> dendriteEnvelope = (Class<?>) genericDendriteEnvelope.getRawType();

Class<?> dummy = (Class<?>) genericDendriteEnvelope.getActualTypeArguments()[0];