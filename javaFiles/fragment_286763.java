prunsrv.exe install "MeineAnwendung" \
--Install="C:/pfad/zu/prunsrv.exe" \
--JvmOptions=-Dpidfile.path=NUL
--Jvm=auto \
--Startup=auto \
--StartMode=jvm \
--Classpath="c:/irgendwo/anwendung/lib/*;" \
--StartClass=play.core.server.NettyServer