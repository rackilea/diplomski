templateRepository.findActiveTemplate(tenantId)
            .flatMap(bo -> {
                bo.setStatus(TemplateStatusEnum.DEACTIVATED);
                return Mono.just(bo);
            })
            .flatMap(templateRepository::updateTemplate)
            .flatMap(templateBo -> templateVersionRepository.findPublishedByTemplateId(templateBo.getId())
                    .flatMap(version -> {
                        version.setStatus(TemplateVersionStatusEnum.MODIFIED);
                        return Mono.just(version);
                    })
                    .flatMap(templateVersionRepository::updateVersion))
            .subscribe()