PVMFStatus AuthorDriver::setParameter(
    const String8& key, const String8& value) {
if (key == "max-duration") {
    int64_t max_duration_ms;
    if (safe_strtoi64(value.string(), &max_duration_ms)) {
        return setMaxDurationOrFileSize(
                max_duration_ms, true /* limit_is_duration */);
    }
} else if (key == "max-filesize") {
    int64_t max_filesize_bytes;
    if (safe_strtoi64(value.string(), &max_filesize_bytes)) {
        return setMaxDurationOrFileSize(
                max_filesize_bytes, false /* limit is filesize */);
    }
} else if (key == "audio-param-sampling-rate") {
    int64_t sampling_rate;
    if (safe_strtoi64(value.string(), &sampling_rate)) {
        return setParamAudioSamplingRate(sampling_rate);
    }
} else if (key == "audio-param-number-of-channels") {
    int64_t number_of_channels;
    if (safe_strtoi64(value.string(), &number_of_channels)) {
        return setParamAudioNumberOfChannels(number_of_channels);
    }
} else if (key == "audio-param-encoding-bitrate") {
    int64_t audio_bitrate;
    if (safe_strtoi64(value.string(), &audio_bitrate)) {
        return setParamAudioEncodingBitrate(audio_bitrate);
    }
} else if (key == "video-param-encoding-bitrate") {
    int64_t video_bitrate;
    if (safe_strtoi64(value.string(), &video_bitrate)) {
        return setParamVideoEncodingBitrate(video_bitrate);
    }
}

// Return error if the key wasnt found
LOGE("AuthorDriver::setParameter() unrecognized key \"%s\"", key.string());
return PVMFErrArgument;
}