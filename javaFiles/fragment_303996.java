FROM busybox

ENV spring_profiles_active dev
ENV encryptor_password xyz

ENTRYPOINT echo ${spring_profiles_active} ${encryptor_password}